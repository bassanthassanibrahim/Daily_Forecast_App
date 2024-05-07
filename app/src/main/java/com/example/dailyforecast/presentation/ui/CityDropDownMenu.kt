package com.example.dailyforecast.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityDropDownMenu(
    state: HomeUiState, listener: HomeListener
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        OutlinedTextField(
            value = state.selectedCity,
            onValueChange = {},
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
                .padding(horizontal = 30.dp),
            textStyle = MaterialTheme.typography.titleSmall,
            readOnly = true,
            enabled = false,
            colors = TextFieldDefaults.colors(
                disabledContainerColor = MaterialTheme.colorScheme.background,
                disabledTextColor = MaterialTheme.colorScheme.onBackground,
                disabledIndicatorColor = MaterialTheme.colorScheme.primary
            ),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowDown,
                    contentDescription = "Arrow",
                    modifier = Modifier.rotate(if (expanded) 180f else 0f),
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        )

        ExposedDropdownMenu(
            modifier = Modifier.background(MaterialTheme.colorScheme.background),
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            state.cities.forEachIndexed { index, selectionOption ->
                DropdownMenuItem(
                    modifier = Modifier.background(MaterialTheme.colorScheme.background),
                    text = {
                        Text(
                            text = selectionOption.cityNameEn,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    onClick = {
                        listener.onCitySelected(
                            state.cities[index].lat,
                            state.cities[index].lon,
                            state.cities[index].cityNameEn
                        )
                        expanded = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                )
            }
        }
    }
}