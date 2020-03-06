package com.oliva.marc.examentecnico.presenter.Impl

import com.oliva.marc.examentecnico.model.interactor.Impl.StateInteractorImpl
import com.oliva.marc.examentecnico.model.interactor.StateInteractor
import com.oliva.marc.examentecnico.presenter.StatePresenter
import com.oliva.marc.examentecnico.view.adapter.StateView

class StatePresenterImpl(val stateView :StateView) :StatePresenter{

    private val stateInteractor : StateInteractor = StateInteractorImpl(this)
    override fun getState() {
        stateInteractor.getState()
    }

    override fun setState(state: Int?) {
        stateView.setState(state)
    }


}