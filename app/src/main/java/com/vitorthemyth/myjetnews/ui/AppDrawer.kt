package com.vitorthemyth.myjetnews.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ListAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vitorthemyth.myjetnews.R
import com.vitorthemyth.myjetnews.ui.theme.MyJetNewsTheme

@Composable
fun AppDrawer(
        currentRoute: String,
        navigateToHome: () -> Unit,
        navigateToInterests: () -> Unit,
        closeDrawer: () -> Unit,
        modifier: Modifier = Modifier
){

    ModalDrawerSheet(modifier) {
        MyNewsLogo(
                modifier = Modifier.padding(horizontal = 28.dp, vertical = 24.dp)
        )

        NavigationDrawerItem(
                label = { Text(text = stringResource(id = R.string.home_title))},
                icon = { Icon(Icons.Filled.Home, contentDescription = null )},
                selected =currentRoute == MyNewsDestinations.HOME_ROUTE,
                onClick = {navigateToHome(); closeDrawer() },
                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )

        NavigationDrawerItem(
                label = { Text(text = stringResource(id = R.string.interests_title))},
                icon = { Icon(Icons.Filled.ListAlt, contentDescription = null )},
                selected =currentRoute == MyNewsDestinations.INTERESTS_ROUTE,
                onClick = {navigateToInterests(); closeDrawer() },
                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )
    }

}

@Composable
fun MyNewsLogo(modifier: Modifier = Modifier){
    Row(modifier = modifier) {
        Icon(
                painterResource(id = R.drawable.ic_jetnews_logo),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.width(8.dp))
        Icon(
                painter = painterResource(R.drawable.ic_jetnews_wordmark),
                contentDescription = stringResource(R.string.app_name),
                tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}


@Preview("Drawer contents", showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL, device = "spec:width=411dp,height=891dp", backgroundColor = 0xFFFFFFFF)
@Preview("Drawer contents (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewAppDrawer() {
    MyJetNewsTheme() {
        AppDrawer(
                currentRoute = MyNewsDestinations.HOME_ROUTE,
                navigateToHome = {},
                navigateToInterests = {},
                closeDrawer = { }
        )
    }
}
