package ro.ase.acs.iocContainer;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class IoC {

    private Map<Class<?>, Class<?>> map = new HashMap<>();

    public void register(Class<?> contract, Class<?> implementation){
     map.put(contract,implementation);
    }

    public <T> T resolve(Class<?> contract){
       try {
            if(map.containsKey(contract)){
                return (T) map.get(contract).newInstance();
            }
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
       return null;
    }
}
