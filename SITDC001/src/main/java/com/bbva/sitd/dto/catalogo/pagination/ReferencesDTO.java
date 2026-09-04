package com.bbva.sitd.dto.catalogo.pagination;

import java.io.Serializable;
import java.util.Objects;

public class ReferencesDTO implements Serializable {
	private static final long serialVersionUID = 4801803395341401233L;
    private String lastPage;
    private String previousPage;
    private String nextPage;
	public String getLastPage() {
		return lastPage;
	}
	public void setLastPage(String lastPage) {
		this.lastPage = lastPage;
	}
	public String getPreviousPage() {
		return previousPage;
	}
	public void setPreviousPage(String previousPage) {
		this.previousPage = previousPage;
	}
	public String getNextPage() {
		return nextPage;
	}
	public void setNextPage(String nextPage) {
		this.nextPage = nextPage;
	}
	@Override
	public int hashCode() {
		return Objects.hash(lastPage, nextPage, previousPage);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReferencesDTO other = (ReferencesDTO) obj;
		return Objects.equals(lastPage, other.lastPage) && Objects.equals(nextPage, other.nextPage)
				&& Objects.equals(previousPage, other.previousPage);
	}
    


}
