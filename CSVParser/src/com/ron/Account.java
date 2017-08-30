package com.ron;

public class Account {

	private long pk;
	private String debit_amount;
	private String credit_amount;
	private String head_office_branch_name;
	private String account_item_name;

	public Account(long pk, String debit_amount, String credit_amount, String head_office_branch_name,
			String account_item_name)

	{
		super();
		this.pk = pk;
		this.debit_amount = debit_amount;
		this.credit_amount = credit_amount;
		this.head_office_branch_name = head_office_branch_name;
		this.account_item_name = account_item_name;
	}

	public long getPk() {
		return pk;
	}

	public void setPk(long pk) {
		this.pk = pk;
	}

	public String getDebit_amount() {
		return debit_amount;
	}

	public void setDebit_amount(String debit_amount) {
		this.debit_amount = debit_amount;
	}

	public String getCredit_amount() {
		return credit_amount;
	}

	public void setCredit_amount(String credit_amount) {
		this.credit_amount = credit_amount;
	}

	public String getHead_office_branch_name() {
		return head_office_branch_name;
	}

	public void setHead_office_branch_name(String head_office_branch_name) {
		this.head_office_branch_name = head_office_branch_name;
	}

	public String getAccount_item_name() {
		return account_item_name;
	}

	public void setAccount_item_name(String account_item_name) {
		this.account_item_name = account_item_name;
	}

	@Override

	public String toString() {
		return "Accounts [pk=" + pk + ", debit_amount=" + debit_amount + ", credit_amount=" + credit_amount
				+ "head_office_branch_name=" + head_office_branch_name + "account_item_name=" + account_item_name + "]";
	}
}
