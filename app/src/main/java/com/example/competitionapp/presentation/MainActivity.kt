package com.example.competitionapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.competitionapp.states.CompetitionState
import com.example.competitionapp.ui.theme.CompetitionAppTheme
import com.example.competitionapp.viewModels.CompetitionViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompetitionAppTheme {
                Column(modifier = Modifier.padding(10.dp)) {
                    TopAppBar()
                    FetchData()
                }
            }
        }
    }
}

@Composable
fun TopAppBar(){
    Text(
        text = "Football Competition",
        textAlign = TextAlign.Center
    )
}

@Composable
fun FetchData(competitionViewModel: CompetitionViewModel = viewModel()){
    when(val state = competitionViewModel.competitionState.collectAsState().value){
        is CompetitionState.Empty -> Text(text = "No data available")
        is CompetitionState.Loading -> Text(text = "Loading...")
        is CompetitionState.Success -> Text(text = "Successful !")
        is CompetitionState.Error -> Text(text = state.message)
    }
}


