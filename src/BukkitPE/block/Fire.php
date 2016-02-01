<?php
namespace BukkitPE\block;

use BukkitPE\entity\Effect;
use BukkitPE\entity\Entity;
use BukkitPE\event\entity\EntityCombustByBlockEvent;
use BukkitPE\event\entity\EntityDamageByBlockEvent;
use BukkitPE\event\entity\EntityDamageEvent;
use BukkitPE\item\Item;
use BukkitPE\level\Level;
use BukkitPE\Server;

class Fire extends Flowable{

	protected $id = self::FIRE;

	public function __construct($meta = 0){
		$this->meta = $meta;
	}

	public function hasEntityCollision(){
		return true;
	}

	public function getName(){
		return "Fire Block";
	}

	public function getLightLevel(){
		return 15;
	}

	public function canBeReplaced(){
		return true;
	}

	public function onEntityCollide(Entity $entity){
		if(!$entity->hasEffect(Effect::FIRE_RESISTANCE)){
			$ev = new EntityDamageByBlockEvent($this, $entity, EntityDamageEvent::CAUSE_FIRE, 1);
			$entity->attack($ev->getFinalDamage(), $ev);
		}

		$ev = new EntityCombustByBlockEvent($this, $entity, 8);
		Server::getInstance()->getPluginManager()->callEvent($ev);
		if(!$ev->isCancelled()){
			$entity->setOnFire($ev->getDuration());
		}
	}

	public function getDrops(Item $item){
		return [];
	}

	public function onUpdate($type){
		if($type === Level::BLOCK_UPDATE_NORMAL){
			if($this->getSide(0)->getId() == self::AIR){
				$this->getLevel()->setBlock($this, new Air(), true, true);
			}
			return Level::BLOCK_UPDATE_NORMAL;
		}elseif($type === Level::BLOCK_UPDATE_RANDOM){
			if($this->getSide(0)->getId() !== self::NETHERRACK){
				$this->getLevel()->setBlock($this, new Air(), true, true);
				return Level::BLOCK_UPDATE_NORMAL;
			}
		}

		return false;
	}

}
