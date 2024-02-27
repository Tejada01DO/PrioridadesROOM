package com.ucne.prioridades_room.ui.consulta

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ucne.prioridades_room.data.local.entities.PrioridadEntity
import com.ucne.prioridades_room.ui.theme.Prioridades_RoomTheme

var showModal by mutableStateOf(false)
var selectedPrioridades by mutableStateOf(PrioridadEntity())

@Composable
fun C_Prioridades(viewModel: C_Prioridades_ViewModel = hiltViewModel()){
    val uiState by viewModel.state.collectAsState()
    Prioridades_RoomTheme{
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            if(uiState.isLoading)
                CircularProgressIndicator(modifier = Modifier
                    .size(80.dp)
                    .padding(0.dp, 50.dp), strokeWidth = 8.dp)
        }

        LazyColumn (
            Modifier.fillMaxSize()
        ){
            item {
                Spacer(modifier = Modifier.padding(0.dp, 10.dp))
            }
            uiState.prioridades?.forEach { prioridades ->
                item {
                    ListPrioridades(prioridades = prioridades)
                }
            }
            item {
                if(showModal){
                    DetailModal(prioridades = selectedPrioridades)
                }
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ListPrioridades(prioridades: PrioridadEntity){

    ElevatedCard(
        onClick = {  },
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(10.dp, 0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clickable { ShowDetails(prioridades) }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(text = "#: ${prioridades.prioridadId}")
                Text(text = "Nombre: ${prioridades.nombre}")
            }
        }
    }
    Spacer(modifier = Modifier.padding(5.dp))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailModal(prioridades: PrioridadEntity){
    androidx.compose.material3.AlertDialog(
        onDismissRequest = {         }
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(330.dp)
                .padding(10.dp, 0.dp)

        ){
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(10.dp, 10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ){
                    IconButton(onClick = { showModal = false }) {
                        Icon(imageVector = Icons.Default.Clear, contentDescription = "Salir")
                    }
                }
                Text(text = "Detalle de la prioridad:")
                Text(text = "#: ${prioridades.prioridadId}")
                Text(text = "Fecha: ${prioridades.nombre}")
                Text(text = "Suplidor #: ${prioridades.descripcion}")
                Text(text = "Suplidor: ${prioridades.plazo}")
            }
        }
    }
}


fun ShowDetails(prioridades: PrioridadEntity){
    showModal = true
    selectedPrioridades = prioridades
}