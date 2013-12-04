package eu.ha3.matmos.engine0.core.implem;

import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

/*
            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE 
                    Version 2, December 2004 

 Copyright (C) 2004 Sam Hocevar <sam@hocevar.net> 

 Everyone is permitted to copy and distribute verbatim or modified 
 copies of this license document, and changing it is allowed as long 
 as the name is changed. 

            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE 
   TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION 

  0. You just DO WHAT THE FUCK YOU WANT TO. 
*/

public class Event extends Descriptible
{
	private Knowledge knowledge;
	
	public ArrayList<String> paths;
	
	public float volMin;
	public float volMax;
	public float pitchMin;
	public float pitchMax;
	
	public int metaSound;
	
	public Event(Knowledge knowledgeIn)
	{
		this.paths = new ArrayList<String>();
		this.knowledge = knowledgeIn;
		
		this.volMin = 1F;
		this.volMax = 1F;
		this.pitchMin = 1F;
		this.pitchMax = 1F;
		
		this.metaSound = 0;
	}
	
	void setKnowledge(Knowledge knowledgeIn)
	{
		this.knowledge = knowledgeIn;
		
	}
	
	public void cacheSounds()
	{
		for (Iterator<String> iter = this.paths.iterator(); iter.hasNext();)
		{
			this.knowledge.getSoundManager().cacheSound(iter.next());
			
		}
		
	}
	
	public void playSound(float volMod, float pitchMod)
	{
		if (this.paths.isEmpty())
			return;
		
		float volume = this.volMax - this.volMin;
		float pitch = this.pitchMax - this.pitchMin;
		volume = this.volMin + (volume > 0 ? this.knowledge.getRNG().nextFloat() * volume : 0);
		pitch = this.pitchMin + (pitch > 0 ? this.knowledge.getRNG().nextFloat() * pitch : 0);
		
		String path = this.paths.get(this.knowledge.getRNG().nextInt(this.paths.size()));
		
		volume = volume * volMod;
		pitch = pitch * pitchMod;
		
		this.knowledge.getSoundManager().playSound(path, volume, pitch, this.metaSound);
	}
	
	@Override
	public String serialize(XMLEventWriter eventWriter) throws XMLStreamException
	{
		buildDescriptibleSerialized(eventWriter);
		
		for (Iterator<String> iter = this.paths.iterator(); iter.hasNext();)
		{
			createNode(eventWriter, "path", iter.next());
			
		}
		
		createNode(eventWriter, "volmin", this.volMin + "");
		createNode(eventWriter, "volmax", this.volMax + "");
		createNode(eventWriter, "pitchmin", this.pitchMin + "");
		createNode(eventWriter, "pitchmax", this.pitchMax + "");
		createNode(eventWriter, "metasound", this.metaSound + "");
		
		return "";
	}
	
}