package info.justinthought.example.common.row

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import info.justinthought.redactable.redactable

@Composable
fun ExampleRowView(data: ExampleRow) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = data.title,
                modifier = Modifier.redactable()
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column(horizontalAlignment = Alignment.Start) {
                Text(
                    text = data.title,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.redactable()
                )

                Text(
                    text = data.subtitle,
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.redactable()
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = data.detail,
                style = MaterialTheme.typography.body1
                    .copy(fontWeight = FontWeight.Light),
                modifier = Modifier.redactable()
            )
        }
    }
}

@Preview
@Composable
fun ExampleRowViewPreview() {
    ExampleRowView(data = ExampleRow.placeholder)
}