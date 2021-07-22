package dicoding.mobileprogramming.faishalammar.imdc.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dicoding.mobileprogramming.faishalammar.imdc.R


class ModuleInstallationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_module_installation, container, false)
    }

}