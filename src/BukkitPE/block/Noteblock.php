<?php
namespace BukkitPE\block;
use BukkitPE\item\Tool;
use BukkitPE\item\Item;
use BukkitPE\level\sound\NoteblockSound;
use BukkitPE\Player;

class Noteblock extends Solid implements RedstoneConsumer{
	protected $id = self::NOTEBLOCK;
	public function __construct($meta = 0){
		$this->meta = $meta;
	}
	public function getHardness(){
		return 0.8;
	}
	public function getResistance(){
		return 4;
	}
	public function getToolType(){
		return Tool::TYPE_AXE;
	}
	public function canBeActivated(){
		return true;
	}
	public function getStrength(){
		if($this->meta < 24) $this->meta ++;
		else $this->meta = 0;
		$this->getLevel()->setBlock($this, $this);
		return $this->meta * 1;
	}
	public function onActivate(Item $item, Player $player = null){
		$this->getLevel()->addSound(new NoteblockSound($this, NoteblockSound::INSTRUMENT_PIANO, $this->getStrength()));
		return true;
	}
	public function getName(){
		return "Noteblock";
	}
}