
package com.monkeysquad.retailnightmare.network;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record BoxGUIButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<BoxGUIButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(RetailNightmareMod.MODID, "box_gui_buttons"));

	public static final StreamCodec<RegistryFriendlyByteBuf, BoxGUIButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, BoxGUIButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new BoxGUIButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<BoxGUIButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final BoxGUIButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;

				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = BoxGUIMenu.guistate;

		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;

		if (buttonID == 0) {

			BoxPackingProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		RetailNightmareMod.addNetworkMessage(BoxGUIButtonMessage.TYPE, BoxGUIButtonMessage.STREAM_CODEC, BoxGUIButtonMessage::handleData);
	}

}
