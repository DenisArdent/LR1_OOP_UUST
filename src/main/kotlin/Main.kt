import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.isCtrlPressed
import androidx.compose.ui.input.key.key
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    var menuItem by mutableStateOf(MenuTopState.TAB_1)

    MaterialTheme {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            MenuTopBar(
                menuState = menuItem,
                onMenuItemClick = { menuTopState ->
                    menuItem = menuTopState
                }
            )
            Spacer(modifier = Modifier.height(15.dp))
            when (menuItem) {
                MenuTopState.TAB_1 -> ButtonsTab()
                MenuTopState.TAB_2 -> TextsTab()
                MenuTopState.TAB_3 -> Tab3()
                MenuTopState.TAB_4 -> RunTab()
            }

        }

    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}


