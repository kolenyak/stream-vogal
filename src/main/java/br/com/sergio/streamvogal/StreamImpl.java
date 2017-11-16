package br.com.sergio.streamvogal;

public class StreamImpl implements Stream {
	
	private char[] charArray;
	private int index;

	public StreamImpl(String s) {
		this.charArray = s.toCharArray();
		this.index = 0;
	}

	@Override
	public char getNext() {
		if(hasNext()) {
			return charArray[index++];
		}
		return 0;
	}

	@Override
	public boolean hasNext() {
		return index < charArray.length;
	}
	

}
