package com.monkeysquad.retailnightmare.block.entity;

public class BoxPackagerBlockEntity extends RandomizableContainerBlockEntity implements WorldlyContainer {
	private NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(3, ItemStack.EMPTY);
	private final SidedInvWrapper handler = new SidedInvWrapper(this, null);

	public BoxPackagerBlockEntity(BlockPos position, BlockState state) {
		super(RetailNightmareModBlockEntities.BOX_PACKAGER.get(), position, state);
	}

	@Override
	public void loadAdditional(CompoundTag compound, HolderLookup.Provider lookupProvider) {
		super.loadAdditional(compound, lookupProvider);
		if (!this.tryLoadLootTable(compound))
			this.stacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		ContainerHelper.loadAllItems(compound, this.stacks, lookupProvider);
	}

	@Override
	public void saveAdditional(CompoundTag compound, HolderLookup.Provider lookupProvider) {
		super.saveAdditional(compound, lookupProvider);
		if (!this.trySaveLootTable(compound)) {
			ContainerHelper.saveAllItems(compound, this.stacks, lookupProvider);
		}
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public CompoundTag getUpdateTag(HolderLookup.Provider lookupProvider) {
		return this.saveWithFullMetadata(lookupProvider);
	}

	@Override
	public int getContainerSize() {
		return stacks.size();
	}

	@Override
	public boolean isEmpty() {
		for (ItemStack itemstack : this.stacks)
			if (!itemstack.isEmpty())
				return false;
		return true;
	}

	@Override
	public Component getDefaultName() {
		return Component.literal("box_packager");
	}

	@Override
	public int getMaxStackSize() {
		return 64;
	}

	@Override
	public AbstractContainerMenu createMenu(int id, Inventory inventory) {
		return new BoxGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(this.worldPosition));
	}

	@Override
	public Component getDisplayName() {
		return Component.literal("Box Packager");
	}

	@Override
	protected NonNullList<ItemStack> getItems() {
		return this.stacks;
	}

	@Override
	protected void setItems(NonNullList<ItemStack> stacks) {
		this.stacks = stacks;
	}

	@Override
	public boolean canPlaceItem(int index, ItemStack stack) {
		return true;
	}

	@Override
	public int[] getSlotsForFace(Direction side) {
		return IntStream.range(0, this.getContainerSize()).toArray();
	}

	@Override
	public boolean canPlaceItemThroughFace(int index, ItemStack stack, @Nullable Direction direction) {
		return this.canPlaceItem(index, stack);
	}

	@Override
	public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
		return true;
	}

	public SidedInvWrapper getItemHandler() {
		return handler;
	}
}