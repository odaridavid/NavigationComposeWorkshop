package dev.davidodari.navigationcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun DetailsScreen(descriptionText: String, onBackNavigation: () -> Unit) {
    Column {
        Image(
            painter = painterResource(id = R.drawable.ic_back_24),
            contentDescription = "Back button",
            modifier = Modifier
                .clip(CircleShape)
                .clickable {
                    onBackNavigation()
                }
                .padding(16.dp)

        )
        Text(
            text = descriptionText,
            modifier = Modifier.padding(16.dp)
        )
    }
}
