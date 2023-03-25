package negocio;

import java.io.Serializable;

public abstract class Entidade implements Serializable {
    public abstract int getId();
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Entidade))
            return false;
        Entidade other = (Entidade)o;
        return other.getId() == getId();
    }
    
}
