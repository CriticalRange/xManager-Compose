package dev.ushiekane.xmanager

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.xinto.taxi.Taxi
import com.xinto.taxi.rememberBackstackNavigator
import dev.ushiekane.xmanager.installer.AppInstallService
import dev.ushiekane.xmanager.ui.navigation.AppDestination
import dev.ushiekane.xmanager.ui.screen.HomeScreen
import dev.ushiekane.xmanager.ui.theme.XManagerTheme

class MainActivity : ComponentActivity() {

    private val installBroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            when (intent?.action) {
                AppInstallService.APP_INSTALL_ACTION -> {

                }
            }
        }
    }

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {

        installSplashScreen()

        super.onCreate(savedInstanceState)
        setContent {
            XManagerTheme {
                val navigator = rememberBackstackNavigator<AppDestination>(AppDestination.Home)

                BackHandler {
                    navigator.pop()
                }

                Taxi(
                    modifier = Modifier.fillMaxSize(),
                    navigator = navigator,
                    transitionSpec = { fadeIn() with fadeOut() }
                ) { destination ->
                    when (destination) {
                        is AppDestination.Home -> HomeScreen(
                            onClickSettings = { /* TODO */ }
                        )
                    }
                }
            }
        }
    }
    override fun onStart() {
        super.onStart()
        registerReceiver(
            installBroadcastReceiver,
            IntentFilter().apply {
                addAction(AppInstallService.APP_INSTALL_ACTION)
            }
        )
    }

    override fun onStop() {
        super.onStop()

        unregisterReceiver(installBroadcastReceiver)
    }
}