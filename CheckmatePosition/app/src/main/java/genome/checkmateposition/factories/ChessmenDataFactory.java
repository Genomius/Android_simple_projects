package genome.checkmateposition.factories;

import android.content.res.AssetManager;
import genome.checkmateposition.MainActivity;
import genome.checkmateposition.dao.ICombinationDao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class ChessmenDataFactory {
    private static ChessmenDataFactory instance;
    private ICombinationDao combinationDao;

    static {
        instance = new ChessmenDataFactory();
    }

    public ChessmenDataFactory() {
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(
                    "/home/den/AndroidStudioProjects/CheckmatePosition/app/src/main/res/database/context.properties"));
            String dataType = properties.getProperty("data.type");
            String dataClass = properties.getProperty("data." + dataType);
            if(dataType.equals("file")){
                String dataFileUrl = properties.getProperty("data.file.url");
                Constructor<?> constructor = Class.forName(dataClass).getConstructor(String.class);
                combinationDao = (ICombinationDao)constructor.newInstance(dataFileUrl);
            }
        } catch (IOException | IllegalAccessException | InstantiationException | ClassNotFoundException |
                NoSuchMethodException |InvocationTargetException e) {
            throw new IllegalArgumentException(e);
        }

    }

    public ICombinationDao getCombinationDao() {
        return combinationDao;
    }

    public static ChessmenDataFactory getInstance() {
        return instance;
    }
}
