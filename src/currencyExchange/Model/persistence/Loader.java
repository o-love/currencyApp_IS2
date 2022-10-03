package currencyExchange.Model.persistence;

import java.util.Collection;

public interface Loader<T> {

    Collection<T> load();
}
