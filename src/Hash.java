public class Hash <TKey, TVal> {

	Hash (int size) {
		mSize = size;
		mArray = new Node [mSize];
	}
	
	private int getHashKey(TKey key) {
		return Math.abs(key.hashCode()) % mSize;
	}
	
	public void insert (TKey key, TVal value) {
		Node <TKey, TVal> newNode = new Node <TKey, TVal> (key, value);
		if (mArray[getHashKey(key)] == null) {
			mArray[getHashKey(key)] = newNode;
			mCounter ++;
		}
		else if (containsKey(key)){
			System.out.println("Key " + newNode.getKey() + " is already there");
		}
		else {
			newNode.mNext = mArray[getHashKey(key)];
			mArray[getHashKey(key)] = newNode;
			mCounter ++;
		}
		
	}


	public int count () {
		return mCounter;
	}
	
	public boolean containsKey (TKey key) {
		Node <TKey, TVal> current = mArray[getHashKey(key)];
		while (current != null) {
			if (current.getKey().equals(key))
				return true;
			else
				current = current.mNext;
		}
		return false;
	}
	
	public TVal find (TKey key) {
		Node <TKey, TVal> current = mArray[getHashKey(key)];
		while (current != null) {
			if (current.getKey().equals(key))
				return (TVal)(current.getValue());
			else
				current = current.mNext;
		}
		return null;
	}
	
	public Object [] keySet () {
		Object a[] = new Object [count()];
		Node <TKey, TVal> current;
		int j = 0;
		for (int i = 0; i < mSize; i++) {
			current = mArray[i];
			while (current != null) {
				a[j] = current.getKey();
				++j;
				current = current.mNext;
			}
		}
		return a;
	}
	
	public void remove (TKey key) {
		if (!containsKey(key)) {
			System.out.println("Key not in hash table");
		}
		else {
			Node <TKey, TVal> current = mArray[getHashKey(key)];
			if (current.getKey().equals(key))
				 mArray[getHashKey(key)] = current.mNext;
			else {
				while (true){
					if (current.mNext.getKey().equals(key)) {
						current.mNext = current.mNext.mNext;
						break;
					}
					current = current.mNext;
				}
			}
		}
		mCounter --;
	}
	
	private class Node <TKey, TVal> {
		
		Node() {
			this (null, null);
		}
		
		Node (TKey key, TVal value) {
			mKey = key;
			mValue = value;
			mNext = null;
		}
		
		public TKey getKey() {
			return mKey;
		}
		
		public TVal getValue() {
			return mValue;
		}
		
		public String toString () {
			return mKey + "\n" + mValue;
		}
		
		private TKey mKey;
		private TVal mValue;
		Node <TKey, TVal> mNext;
	}
	

	private Node<TKey, TVal> [] mArray;
	private int mSize;
	private int mCounter;
}


