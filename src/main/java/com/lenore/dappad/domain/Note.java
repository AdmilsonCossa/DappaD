package com.lenore.dappad.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "note")
public class Note extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;

    private String text;
    
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "notebook_id")
    private Notebook nb;

//    @ManyToOne(optional = true, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
//    private Username user;
    
    public Note() {
    	super();
    	this.nb = new Notebook();
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
