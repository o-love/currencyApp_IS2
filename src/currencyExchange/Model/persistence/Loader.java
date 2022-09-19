package currencyExchange.Model.persistence;

import java.util.List;

public interface Loader<T> {

    List<T> load();
}
