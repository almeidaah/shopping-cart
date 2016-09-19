package job.request.almeida.fernando.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

public class ShoppingCart {

	@Id
	private String id;
	
	private CommerceItem[] commerceItems;
	private BigDecimal amount;

	public CommerceItem[] getCommerceItems() {
		return commerceItems;
	}

	public void setCommerceItems(CommerceItem[] commerceItems) {
		this.commerceItems = commerceItems;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
