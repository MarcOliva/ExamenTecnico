package com.oliva.marc.examentecnico.model.interactor.Impl

import com.oliva.marc.examentecnico.model.interactor.StateInteractor
import com.oliva.marc.examentecnico.model.repository.StateRepository
import com.oliva.marc.examentecnico.model.repository.impl.StateRepositoryImpl
import com.oliva.marc.examentecnico.presenter.StatePresenter

class StateInteractorImpl(statePresenter: StatePresenter) :StateInteractor{
    private val stateRepository: StateRepository = StateRepositoryImpl(statePresenter)
    override fun getState() {
        stateRepository.getState()
    }

}