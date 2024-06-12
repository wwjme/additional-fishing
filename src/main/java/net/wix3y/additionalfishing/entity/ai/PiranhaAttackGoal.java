package net.wix3y.additionalfishing.entity.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.wix3y.additionalfishing.entity.custom.PiranhaEntity;

public class PiranhaAttackGoal extends MeleeAttackGoal {
    private final PiranhaEntity entity;
    private int ticksUntilNextAttack = 40;
    private boolean countUntilNextAttack = false;

    public PiranhaAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        entity = ((PiranhaEntity) mob);
    }

    @Override
    public void start() {
        super.start();
        ticksUntilNextAttack = 40;
    }

    @Override
    protected void attack(LivingEntity target, double squaredDistance) {
        if (isEnemyWithinAttackDistance(target, squaredDistance)) {
            countUntilNextAttack = true;
            if(isTimeToAttack()) {
                entity.setAttacking(true);
                this.mob.getLookControl().lookAt(target.getX(), target.getEyeY(), target.getZ());
                performAttack(target);
            }
        } else {
            resetAttackCooldown();
            countUntilNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeout = 0;
        }
    }

    private boolean isEnemyWithinAttackDistance(LivingEntity target, double squaredDistance) {
        return squaredDistance <= this.getSquaredMaxAttackDistance(target);
    }

    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.getTickCount(40);
    }

    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 0;
    }

    protected void performAttack(LivingEntity pEnemy) {
        this.resetAttackCooldown();
        this.mob.tryAttack(pEnemy);
    }

    @Override
    public void tick() {
        super.tick();
        if(countUntilNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }
    }

    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
    }
}
