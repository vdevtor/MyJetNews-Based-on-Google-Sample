package com.vitorthemyth.myjetnews.glance.ui.theme

import androidx.glance.color.ColorProvider
import androidx.glance.material3.ColorProviders
import com.vitorthemyth.myjetnews.ui.theme.DarkColors
import com.vitorthemyth.myjetnews.ui.theme.LightColors

object JetnewsGlanceColorScheme {
    val colors = ColorProviders(
        light = LightColors,
        dark = DarkColors
    )

    val outlineVariant = ColorProvider(
        day = LightColors.onSurface.copy(alpha = 0.1f),
        night = DarkColors.onSurface.copy(alpha = 0.1f)
    )
}
