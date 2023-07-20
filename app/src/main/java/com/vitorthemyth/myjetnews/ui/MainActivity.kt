package com.vitorthemyth.myjetnews.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.core.view.WindowCompat
import com.vitorthemyth.myjetnews.MyNewsApplication
import com.vitorthemyth.myjetnews.ui.theme.MyJetNewsTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val appContainer = (application as MyNewsApplication).container
        setContent {
            MyJetNewsTheme {
                val widthSizeClass = calculateWindowSizeClass(this).widthSizeClass
                MyNewsApp(appContainer, widthSizeClass)
            }
        }
    }
}