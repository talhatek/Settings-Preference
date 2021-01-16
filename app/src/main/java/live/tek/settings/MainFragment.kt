package live.tek.settings

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.appbar.AppBarLayout
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat


class MainFragment : Fragment() {
    private lateinit var toolbar: Toolbar
    private lateinit var bar: AppBarLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        childFragmentManager.addOnBackStackChangedListener {
            if (childFragmentManager.backStackEntryCount > 0){

                toolbar.title=childFragmentManager.findFragmentById(R.id.inner_container)?.tag
                toolbar.navigationIcon = ResourcesCompat.getDrawable(
                    resources,
                    R.drawable.arrow_back,
                    requireActivity().theme
                )}
            else{
                toolbar.navigationIcon = null
                toolbar.title="Settings"
            }

            Log.e("backStack", "count => ${childFragmentManager.backStackEntryCount}")
        }
        toolbar.setNavigationOnClickListener {
            childFragmentManager.popBackStack()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        toolbar = view.findViewById(R.id.toolbar)
        bar = view.findViewById(R.id.bar)
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
        return view
    }


}
