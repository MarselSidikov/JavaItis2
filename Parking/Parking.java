class Parking {
	private static final int MAX_AUTO = 10;

	private Transport[] transports;
	private int transportCount;

	public Parking() {
		this.transports = new Transport[MAX_AUTO];
		this.transportCount = 0;
	}

	public void addTransport(Transport transport) {
		if (this.transportCount <= MAX_AUTO) {
			this.transports[transportCount] = transport;
			 transportCount++;
		} else {
			System.out.println("OUT OF PARKING");
		}
	}

	public void removeFromParking(Transport transport) {
		int transportNumber = transport.getNumber();

		int indexOfRemovingTransport = 0;

		for (int i = 0; i < transportCount; i++) {
			if (transports[i].getNumber() == transportNumber) {
				indexOfRemovingTransport = i;
				break;
			}
		}

		for (int i = indexOfRemovingTransport; i < transportCount; i++) {
			transports[i] = transports[i + 1];
		}

		transportCount--;
	}
}