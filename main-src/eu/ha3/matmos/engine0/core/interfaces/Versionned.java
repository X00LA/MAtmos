package eu.ha3.matmos.engine0.core.interfaces;

/*
--filenotes-placeholder
*/

public interface Versionned
{
	/**
	 * Gets the version of this. Starts at -1.
	 * 
	 * @return
	 */
	public int version();
	
	/**
	 * Increments the version.
	 */
	public void incrementVersion();
}