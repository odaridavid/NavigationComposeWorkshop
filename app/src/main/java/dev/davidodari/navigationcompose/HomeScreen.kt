package dev.davidodari.navigationcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(navigateToDetails: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.weight(0.5f))
        Text(
            text = stringResource(R.string.home_screen_text),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Button(
            onClick = { navigateToDetails() },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Go To Details")
        }
        Spacer(modifier = Modifier.weight(0.5f))
    }
}
