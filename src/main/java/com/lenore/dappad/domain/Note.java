package com.lenore.dappad.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "notes")
public class Note implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    private String title;

    private String text;
    
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "notebook_id")
    private Notebook nb;

    public Note() {
    	super();
    	this.nb = new Notebook();
    }
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Notebook getNb() {
		return nb;
	}

	public void setNb(Notebook notebook) {
		this.nb = notebook;
	}


}
