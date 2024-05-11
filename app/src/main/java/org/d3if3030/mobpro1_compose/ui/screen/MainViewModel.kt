import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.d3if3030.mobpro1_compose.database.CatatanDao
import org.d3if3030.model.Catatan

class MainViewModel(private val dao: CatatanDao, title: String) : ViewModel() {
    private val _data = MutableStateFlow<List<Catatan>>(emptyList())
    val data = _data.asStateFlow()

    init {
       viewModelScope.launch{
           Log.d("TITLE", title)
           dao.getByBook(title).collect{newData ->
               _data.update { newData }
           }
       }
    }

}
