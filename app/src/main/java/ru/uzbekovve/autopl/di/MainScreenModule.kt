package ru.uzbekovve.autopl.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.uzbekovve.autopl.ui.screens.all_chats.AllChatsViewModel

fun mainScreenModule() = module {

    viewModel {
        AllChatsViewModel()
    }
}