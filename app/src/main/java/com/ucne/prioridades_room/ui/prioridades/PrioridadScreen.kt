package com.ucne.prioridades_room.ui.prioridades

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun PrioridadScreen(
    viewModel: PrioridadViewModel = hiltViewModel()
) {
    val stateVertical = rememberScrollState(0)
    val state by viewModel.state.collectAsStateWithLifecycle()
    val prioridad = state.prioridad

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(state = stateVertical),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Registro de Prioridades",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = prioridad.nombre,
                onValueChange = { viewModel.onEvent(PrioridadEvent.NombreChanged(it)) },
                label = { Text(text = "Nombre") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            )

            OutlinedTextField(
                value = prioridad.descripcion,
                onValueChange = { viewModel.onEvent(PrioridadEvent.DescripcionChanged(it)) },
                label = { Text(text = "Descripcion") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),

                )

            OutlinedTextField(
                value = prioridad.plazo.toString(),
                onValueChange = { viewModel.onEvent(PrioridadEvent.PlazoChanged(it)) },
                label = { Text(text = "Plazo: ") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp, 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        viewModel.onEvent(PrioridadEvent.onSave)
                    },
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "Guardar")
                        Spacer(modifier = Modifier.width(4.dp))
                    }
                }

                Button(
                    onClick = {
                        viewModel.onEvent(PrioridadEvent.onLimpiar)
                    },
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(imageVector = Icons.Default.Refresh, contentDescription = "Limpiar")
                        Spacer(modifier = Modifier.width(4.dp))
                    }
                }
            }
        }
    }
}