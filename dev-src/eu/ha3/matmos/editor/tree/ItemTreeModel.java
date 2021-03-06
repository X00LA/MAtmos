package eu.ha3.matmos.editor.tree;

import eu.ha3.matmos.editor.interfaces.ISerialUpdate;
import eu.ha3.matmos.jsonformat.serializable.expansion.SerialRoot;

import javax.swing.tree.DefaultTreeModel;

/*
--filenotes-placeholder
*/

@SuppressWarnings("serial")
public class ItemTreeModel extends DefaultTreeModel implements ISerialUpdate
{
	public ItemTreeModel()
	{
		super(new ItemTreeRoot());
	}
	
	@Override
	public void updateSerial(SerialRoot root)
	{
		getItemTreeRoot().updateSerial(root);
	}
	
	public ItemTreeRoot getItemTreeRoot()
	{
		return (ItemTreeRoot) getRoot();
	}
}
