public interface StworzObiektZeStringa {
	
	static Object New (Class<?> klasa){//Ta funkcja wywo³uje konstrukcje obiektu o typie przekazanym w parametrze.
		try {
			return	klasa.newInstance();
			//klasa.getDeclaredConstructor(parameterTypes[np. <int>]).newInstance(); dla konstruktora z argumentami
		} catch (Exception e) {
			return null;
		}
    }
}

