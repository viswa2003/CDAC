package com.viswa;

public class Transaction {

	int txId;
	float txAmount;
	boolean txStatus;
	boolean txArrears;
	
	public Transaction(int id, float amount, boolean status, boolean arrears) {
		this.txId = id;
		this.txAmount = amount;
		this.txStatus = status;
		this.txArrears = arrears;
	}

	public int getTxId() {
		return txId;
	}

	public void setTxId(int txId) {
		this.txId = txId;
	}

	public float getTxAmount() {
		return txAmount;
	}

	public void setTxAmount(float txAmount) {
		this.txAmount = txAmount;
	}

	public boolean isTxStatus() {
		return txStatus;
	}

	public void setTxStatus(boolean txStatus) {
		this.txStatus = txStatus;
	}

	public boolean isTxArrears() {
		return txArrears;
	}

	public void setTxArrears(boolean txArrears) {
		this.txArrears = txArrears;
	}

	@Override
	public String toString() {
		return "Transaction [txId=" + txId + ", txAmount=" + txAmount + ", txStatus=" + txStatus + ", txArrears="
				+ txArrears + "]";
	}
	
	
	
}
