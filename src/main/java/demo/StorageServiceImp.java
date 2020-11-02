package demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImp implements StorageService {
	private Map<String, Map<String, Object>> myStorage;
	
	@Autowired
	public StorageServiceImp(Map<String, Map<String, Object>> myStorage) {
		super();
		this.myStorage = myStorage;
	}

	@Override
	public KeyValuePair store(String key, Map<String, Object> value) {
		if (!this.myStorage.containsKey(key)) {
			this.myStorage.put(key, value);
			return new KeyValuePair(key, value);
		} else {
			throw new KeyAlreadyExistsException("The value you trying to insert is already exists.");
		}
	}

	@Override
	public Map<String, Object> getValueByKey(String key) {
		return this.myStorage.get(key);
	}

	@Override
	public void updateExistingValue(String key, Map<String, Object> updatedValue) {
		if (this.myStorage.containsKey(key)) {
			this.myStorage.put(key, updatedValue);
		}
	}

	@Override
	public void deleteValueByKey(String key) {
		if (this.myStorage.containsKey(key)) {
			this.myStorage.remove(key);
		}
	}

	@Override
	public void deleteAll() {
		this.myStorage.clear();
	}

	@Override
	public List<KeyValuePair> getAll(int size, int page) {
		// TODO Auto-generated method stub
		return null;
	}

}
