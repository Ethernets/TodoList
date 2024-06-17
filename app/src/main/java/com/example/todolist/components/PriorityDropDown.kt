package com.example.todolist.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todolist.R
import com.example.todolist.data.models.Priority

@Composable
fun PriorityDropDown(
    priority: Priority,
    onPrioritySelected: (Priority) -> Unit,
) {
    var expended by remember { mutableStateOf(false) }
    val angle: Float by animateFloatAsState(targetValue = if (expended) 180f else 0f, label = "FloatAnimation")
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clickable { expended = true }
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.0f)//priority.color
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Canvas(
            modifier = Modifier
                .size(16.dp)
                .weight(1f)
        ) {
            drawCircle(
                color = priority.color,
            )
        }
        Text(
            modifier = Modifier.weight(8f),
            text = priority.name,
            style = MaterialTheme.typography.labelMedium,
        )
        IconButton(
            modifier = Modifier
                .weight(1.5f)
                .alpha(0.5f)
                .rotate(degrees = angle),
            onClick = { expended = true }
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = stringResource(R.string.drop_down_arrow_icon)
            )
        }

        DropdownMenu(
            modifier = Modifier
                .fillMaxWidth(fraction = 0.94f),
            expanded = expended,
            onDismissRequest = { expended = false },
        ) {
            DropdownMenuItem(
                text = { Text(text = Priority.LOW.name) },
                onClick = {
                    expended = false
                    onPrioritySelected(Priority.LOW)
                })

            DropdownMenuItem(
                text = { Text(text = Priority.MEDIUM.name) },
                onClick = {
                    expended = false
                    onPrioritySelected(Priority.MEDIUM)
                })

            DropdownMenuItem(
                text = { Text(text = Priority.HIGH.name) },
                onClick = {
                    expended = false
                    onPrioritySelected(Priority.HIGH)
                })
        }
    }
}

@Composable
@Preview
fun PreviewPriorityDropDown() {
    PriorityDropDown(
        priority = Priority.HIGH,
        onPrioritySelected = {}
    )
}