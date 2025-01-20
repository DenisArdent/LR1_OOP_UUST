import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

@Composable
fun MenuTopBar(
    menuState: MenuTopState,
    onMenuItemClick: (MenuTopState) -> Unit
) {
    Row {
        for (i in MenuTopState.entries) {
            MenuItem(
                modifier = Modifier.weight(1f),
                name = i.value,
                isSelected = menuState == i,
                onClick = { onMenuItemClick(i) }
            )
        }
    }

}

@Composable
fun MenuItem(
    modifier: Modifier = Modifier,
    name: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val mutableInteractionSource = MutableInteractionSource()
    Box(
        modifier = modifier
            .clickable(
                mutableInteractionSource,
                indication = null,
                onClick = onClick
            )
            .fillMaxWidth()
            .background(if (isSelected) Color.DarkGray else Color.White),
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = name,
                color = if (isSelected) Color.White else Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}

enum class MenuTopState(val value: String) {
    TAB_1("Кнопки"),
    TAB_2("Тексты и формы"),
    TAB_3("Элементы выбора и др.")
}