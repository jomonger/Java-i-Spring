
public interface StworzObiektZeStringa {
	static Object New (Class<?> klasa){
		try {
			return	klasa.newInstance();
			//klasa.getDeclaredConstructor(parameterTypes[np. <int>]).newInstance(); dla konstruktora z argumentami
		} catch (Exception e) {
			return null;
		}
    }
}

