package com.vitorthemyth.myjetnews.glance

import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import com.vitorthemyth.myjetnews.glance.ui.JetnewsGlanceAppWidget

class JetnewsGlanceAppWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = JetnewsGlanceAppWidget()
}