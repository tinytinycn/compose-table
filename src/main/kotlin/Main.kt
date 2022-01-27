// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application


fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        val headers = listOf("序号", "姓名", "操作")
        val bodyData: List<Item> = DataProvider.testItems
        Box(
            Modifier
                .border(border = BorderStroke(Dp.Hairline, color = Color.LightGray))
                .padding(20.dp)
        ) {
            SimpleTable(
                modifier = Modifier.height(300.dp),
                row = bodyData.size,
                col = headers.size,
                onRowSelected = { singleSelectionRowIndex, singleSelectionRowToggle ->
                    println("row-$singleSelectionRowIndex ${if (singleSelectionRowToggle) "isSelected" else "unSelected"}")
                },
                headerData = headers
            ) { row, col ->
                when (col) {
                    0 -> Text(text = bodyData[row].id.toString(), style = MaterialTheme.typography.body1)
                    1 -> Text(text = bodyData[row].name, style = MaterialTheme.typography.body1)
                    2 -> Checkbox(checked = bodyData[row].isSelected, onCheckedChange = null)
                }
            }
        }
    }
}
