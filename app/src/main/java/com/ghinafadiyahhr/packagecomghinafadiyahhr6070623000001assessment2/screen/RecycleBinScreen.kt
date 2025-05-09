package com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.R
import com.ghinafadiyahhr.packagecomghinafadiyahhr6070623000001assessment2.model.Belanja

@Composable
fun RecycleBinScreen(
    belanja: Belanja,
    onRestore: () -> Unit,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = belanja.namaBarang,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold
            )
            Text(text = stringResource(R.string.jumlah) + ": ${belanja.jumlah}")
            if (belanja.keterangan.isNotEmpty()) {
                Text(
                    text = belanja.keterangan,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Text(text = belanja.tanggal)

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(top = 8.dp)
            ) {
                androidx.compose.material3.Button(onClick = onRestore) {
                    Text(text = stringResource(R.string.pulihkan))
                }
                androidx.compose.material3.Button(onClick = onDelete) {
                    Text(text = stringResource(R.string.hapus_permanen))
                }
            }
        }
    }
}
