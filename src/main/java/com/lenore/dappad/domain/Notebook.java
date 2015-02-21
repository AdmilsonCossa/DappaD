package com.lenore.dappad.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "notebook")
public class Notebook extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "isDefault")
	private boolean isDefault;

	private String title;

	@OneToMany(targetEntity = Note.class, mappedBy = "nb", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Note> notes = new ArrayList<Note>();

	// Getters and setters //

	public Notebook() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public boolean isDefault() {
		return isDefault;
	}
	
	public boolean getIsDefault() {
		return isDefault;
	}
	
	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public void setIsDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}
	
}
