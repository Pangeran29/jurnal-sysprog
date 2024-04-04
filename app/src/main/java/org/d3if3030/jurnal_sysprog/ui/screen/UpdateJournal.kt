package org.d3if3030.jurnal_sysprog.ui.screen

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.d3if3030.jurnal_sysprog.R
import org.d3if3030.jurnal_sysprog.ui.theme.Jurnal_sysprogTheme
import org.d3if3030.model.Journal
import org.d3if3030.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateJournalScreen(navHostController: NavHostController) {
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Text(text = stringResource(id = R.string.update_journal_top_title))
                    }
                },
                modifier = Modifier
                    .padding(10.dp)
                    .clip(RoundedCornerShape(20.dp)),
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navHostController.popBackStack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Menu Icon",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            )
        }
    ) {
        UpdateJournalScreenContent(Modifier.padding(it), navHostController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateJournalScreenContent(modifier: Modifier, navHostController: NavHostController) {
    var chapter by rememberSaveable { mutableStateOf("")}
    var journal by rememberSaveable { mutableStateOf("")}
    var chapterErr by rememberSaveable { mutableStateOf(false)}
    var journalErr by rememberSaveable { mutableStateOf(false)}
    val understandingOption = listOf<String>(
        stringResource(R.string.yes),
        stringResource(R.string.no)
    )
    var understand by rememberSaveable { mutableStateOf(understandingOption[0])}

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            OutlinedTextField(
                value = chapter,
                onValueChange = { chapter = it},
                label = { Text(text = stringResource(R.string.journal_chapter))},
                isError = chapterErr,
                supportingText = { ErrorHint(chapterErr)},
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            OutlinedTextField(
                value = journal,
                onValueChange = { journal = it},
                label = { Text(text = stringResource(R.string.journal_content))},
                isError = journalErr,
                supportingText = { ErrorHint(journalErr)},
                singleLine = false,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            Text(
                text = stringResource(id = R.string.understand_topic),
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.padding(top = 6.dp)
            )
        }
        item {
            Row(
                modifier = Modifier
                    .padding(top = 6.dp)
                    .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
            ) {
                understandingOption.forEach{ text ->
                    UnderstandingOption(
                        label = text,
                        isSelected = understand == text,
                        modifier = Modifier
                            .selectable(
                                selected = understand == text,
                                onClick = { understand = text },
                                role = Role.RadioButton
                            )
                            .weight(1f)
                            .padding(16.dp)
                    )
                }
            }
        }
        item {
            Button(
                onClick = {
                    chapterErr = (chapter == "")
                    journalErr = (journal == "")
                    if (chapterErr || journalErr) return@Button
                    MainViewModel.data.add(Journal(chapter, journal, understand))
                    navHostController.popBackStack()

                },
                modifier = Modifier.padding(top = 8.dp),
                contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp)
            ) {
                Text(text = stringResource(R.string.add_journal))
            }
        }
    }
}

@Composable
fun UnderstandingOption(label: String, isSelected: Boolean, modifier: Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = isSelected, onClick = null)
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Composable
fun ErrorHint(isError: Boolean) {
    if (isError) {
        Text(text = stringResource(R.string.input_invalid))
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun UpdateJouralPreview() {
    Jurnal_sysprogTheme {
        UpdateJournalScreen(rememberNavController())
    }
}