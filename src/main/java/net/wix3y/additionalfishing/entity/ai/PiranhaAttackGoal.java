package net.wix3y.additionalfishing.entity.ai;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Hand;

public class PiranhaAttackGoal extends MeleeAttackGoal {
    private int ticksUntilNextAttack = 20;
    private boolean countUntilNextAttack = false;

    public PiranhaAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
    }

    @Override
    public void start() {
        super.start();
        ticksUntilNextAttack = 20;
    }

    @Override
    protected void attack(LivingEntity target, double squaredDistance) {
        if (squaredDistance <= this.getSquaredMaxAttackDistance(target)) {
            countUntilNextAttack = true;
            if(this.ticksUntilNextAttack <= 0) {
                this.mob.getLookControl().lookAt(target.getX(), target.getEyeY(), target.getZ());
                performAttack(target);
            }
        } else {
            resetAttackCooldown();
            countUntilNextAttack = false;
        }
    }

    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.getTickCount(20);
    }

    protected void performAttack(LivingEntity target) {
        this.resetAttackCooldown();
        this.mob.swingHand(Hand.MAIN_HAND);
        this.mob.tryAttack(target);
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
        super.stop();
    }
}
