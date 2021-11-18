package entities;

import java.util.Date;

public class LogEntry {
	/* precisa do HashCode e Equals para poder comparar o conteudo 
	 * sem o HashCode e Equals ele ia comparar a referencia de memoria*/

	private String username;
	private Date moments;

	public LogEntry(String username, Date moments) {
		this.username = username;
		this.moments = moments;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getMoments() {
		return moments;
	}

	public void setMoments(Date moments) {
		this.moments = moments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogEntry other = (LogEntry) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
