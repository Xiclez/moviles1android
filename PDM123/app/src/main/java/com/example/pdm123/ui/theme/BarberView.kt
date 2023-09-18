package com.example.pdm123.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import com.example.pdm123.R
@Composable
fun BarberView(viewModel: BarberViewModel) {
    val cutResult by viewModel.getCutCount().observeAsState(0)
    val beardResult by viewModel.getBeardCount().observeAsState(0)
    val cnbResult by viewModel.getCutAndBeard().observeAsState(0)
    val totalResult by viewModel.getTotal().observeAsState(0)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.corte),
                    contentDescription = "Barber",
                    modifier = Modifier.size(120.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = { viewModel.addCut() }) {
                    Text(text = "Corte")
                }
                Text(text = "${cutResult}")
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.barba),
                    contentDescription = "Barber",
                    modifier = Modifier.size(120.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = { viewModel.addBeard() }) {
                    Text(text = "Barba")
                }
                Text(text = "${beardResult}")
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.barba_pelo),
                    contentDescription = "Barber",
                    modifier = Modifier.size(120.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = { viewModel.addCutnBeard() }) {
                    Text(text = "Corte y Barba")
                }
                Text(text = "${cnbResult}")
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "${totalResult}")
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}
